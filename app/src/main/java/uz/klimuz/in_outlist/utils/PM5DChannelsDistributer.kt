package uz.klimuz.in_outlist.utils

import android.annotation.SuppressLint
import android.util.Log

val channelList: ArrayList<Channel> = ArrayList()
val extraChannelList: ArrayList<Channel> = ArrayList()
var channelNumber = 1 //number of desk's channel minus 1 to fit array list's index
var channel = Channel()
fun mainFunction(): ArrayList<Channel> {
    fillEmptyChannels(0, 47)
    distributeSoloists()
    distributeDrums()
    distributeGuitars()
    distributeKeyboards()

    distributeNational()
    distributePercussion()
    distributeBacks()
    distribStrings()
    distribWoods()
    distribBrass()

    distribPlaybacks()
    distribExtraChannels()
    return channelList
}
fun fillEmptyChannels(startFrom: Int, untill: Int) {// must go very first
    channelList.clear()
    for (i in (startFrom..untill)) {
        val emptyChannel = Channel(name = "---", number = i + 1)
        channelList.add(i, emptyChannel)
    }
}
fun distributeSoloists() {// must go after fun fillEmptyChannels
    channelNumber = 25 - countChannelsForInstrumentsInTheGroup(soloistInstrumentsList)
    for (i in soloistInstrumentsList) {
       putInstrumentToChannels(i)
    }
}
fun distributeDrums(){
    if (isDrumsInLowerLayer()){
        channelNumber = 25
    }else{
        channelNumber = 1
    }
    for (i in drumInstrumentsList){
        putInstrumentToChannels(i)
    }
}
fun distributeKeyboards() {
    if (isDrumsInLowerLayer()){
        channelNumber = 1
    }else {
        channelNumber = 25
    }
    for (i in keyboardInstrumentsList){
        putInstrumentToChannels(i)
    }
}
fun distributeGuitars() {
    for (i in guitarInstrumentsList) {
        putInstrumentToChannels(i)
    }
}
fun distributeNational(){
    for (i in nationalInstrumentsList) {
        putInstrumentToChannels(i)
    }
}
fun distributePercussion(){
    for (i in percussionInstrumentsList) {
        putInstrumentToChannels(i)
    }
}
fun distributeBacks(){
    for (i in backVocalInstrumentsList) {
        putInstrumentToChannels(i)
    }
}
fun distribStrings(){
    for (i in stringInstrumentsList){
        putInstrumentToChannels(i)
    }
}
fun distribWoods(){
    for (i in woodwindInstrumentsList){
        putInstrumentToChannels(i)
    }
}
fun distribBrass(){
    for (i in brassInstrumentsList){
        putInstrumentToChannels(i)
    }
}
fun distribPlaybacks(){
    for (i in playbackInstrumentsList){
        putInstrumentToChannels(i)
    }
}
fun distribExtraChannels(){
    channelNumber = 49 - countChannelsForInstrumentsInTheGroup(extraMicsList)
    for (i in extraMicsList){
        putInstrumentToChannels(i)
    }
}
fun isDrumsInLowerLayer(): Boolean {
    return (countChannelsForInstrumentsInTheGroup(drumInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(guitarInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(nationalInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(soloistInstrumentsList) > 24)
}
fun putInstrumentToChannels(instrument: Instrument) {
    if (instrument.quantity > 0){
        if (instrument.isStereo){
            if (channelNumber % 2 == 0){
                channelNumber += 1
            }
            if (instrument.quantity > 1){
                var count = 1
                for (i in channelNumber until channelNumber + instrument.quantity * 2){
                    if (i % 2 != 0){
                        if (channelList[i - 1].name == "---" && channelList[i].name == "---") {
                            channel = Channel(name = instrument.name + count + "L" + ">1 s hfc",
                                number = i,
                                pickup = instrument.pickup)
                            channelList.removeAt(i - 1)
                            channelList.add(i - 1, channel)
                            channel = Channel(name = instrument.name + count + "R" + ">1 s hfc",
                                number = i + 1,
                                pickup = instrument.pickup)
                            channelList.removeAt(i)
                            channelList.add(i, channel)
                            count ++
                            channelNumber += 2
                        }else{// several stereo, no free
                            if (!isThereChannelsForStereo()){
                                channel = Channel(number = channelList.size)
                                channelList.add(channel)
                                channel = Channel(number = channelList.size)
                                channelList.add(channel)
                            }
                            for (cn in channelList){
                                if (cn.number % 2 != 0 && cn.name == "---" && channelList[channelList.indexOf(cn) + 1].name == "---"){
                                    channel = Channel(name = instrument.name + count + "L" + ">1 s nfc",
                                        number = cn.number,
                                        pickup = instrument.pickup)
                                    channelList.removeAt(cn.number - 1)
                                    channelList.add(cn.number -1, channel)
                                    channel = Channel(name = instrument.name + count + "R" + ">1 s nfc",
                                        number = cn.number + 1,
                                        pickup = instrument.pickup)
                                    channelList.removeAt(cn.number)
                                    channelList.add(cn.number, channel)
                                    channelNumber += 2
                                    if (count == instrument.quantity){
                                        break
                                    }
                                    count ++
                                }
                            }
                        }
                    }
                }
            }else{//one stereo
                if (channelList[channelNumber - 1].name == "---" && channelList[channelNumber].name == "---") {
                    channel = Channel(name = instrument.name + " L" + "1 s hfc",
                        number = channelNumber,
                        pickup = instrument.pickup)
                    channelList.removeAt(channelNumber - 1)
                    channelList.add(channelNumber - 1, channel)
                    channel = Channel(name = instrument.name + " R" + "1 s hfc",
                        number = channelNumber + 1,
                        pickup = instrument.pickup)
                    channelList.removeAt(channelNumber)
                    channelList.add(channelNumber, channel)
                    channelNumber + 2
                }else{//one stereo, no free channels
                    if (!isThereChannelsForStereo()){
                        val channel1 = Channel(number = channelList.size)
                        channelList.add(channel1)
                        val channel2 = Channel(number = channelList.size)
                        channelList.add(channel2)
                    }
                    for (cn in  channelList){
                        if (channelList.indexOf(cn) % 2 == 0 && cn.name == "---" && channelList[channelList.indexOf(cn) + 1].name == "---"){
                            channel = Channel(name = instrument.name + " L" + "1 s nfc",
                                number = cn.number,
                                pickup = instrument.pickup)
                            channelList.removeAt(channel.number - 1)
                            channelList.add(channel.number - 1, channel)
                            channel = Channel(name = instrument.name + " R" + "1 s nfc",
                                number = cn.number + 1,
                                pickup = instrument.pickup)
                            channelList.removeAt(channel.number - 1)
                            channelList.add(channel.number - 1, channel)
                            channelNumber += 2
                            break
                        }
                    }

                }
            }
        }else{//mono
            if (instrument.quantity > 1){
                if (channelNumber == 48){//
                    channel = Channel(name = "---", number = 48)

                    channelList.add(47, channel)

                    channelNumber = 49
                }
                var count = 1
                for (i in channelNumber until channelNumber + instrument.quantity){
                    if (!isThereChannelsForMono()){
                        channel = Channel(number = channelList.size)
                        channelList.add(channel)
                    }
                    if (channelList[i - 1].name == "---"){
                        channel = Channel(name = instrument.name + count + ">1 m hfc",
                            number = i,
                            pickup = instrument.pickup)
                        channelList.removeAt(i - 1)
                        channelList.add(i - 1, channel)
                        count ++
                        channelNumber += 1
                    }else{//channel not free, several mono
                        for (cn in channelList){
                            if (!isThereChannelsForMono()){
                                channel = Channel(number = channelList.size)
                                channelList.add(channel)
                            }
                            if (cn.name == "---"){
                                channel = Channel(name = instrument.name + count + ">1 m nfc",
                                    number = cn.number,
                                    pickup = instrument.pickup)
                                channelList.removeAt(cn.number - 1)
                                channelList.add(cn.number - 1, channel)
                                count++
                                channelNumber +=1
                                break
                            }
                        }
                    }
                }
            }else{//one mono instrument
                if (channelList[channelNumber - 1].name == "---"){
                    channel = Channel(name = instrument.name + "1 m hfc",
                        number = channelNumber,
                        pickup = instrument.pickup)
                    channelList.removeAt(channel.number - 1)
                    channelList.add(channel.number - 1, channel)
                    channelNumber +=1
                }else{//channel not free
                    var names = ""
//    for (c in channelList){
//        names += c.number.toString() + " " + c.name + "\n"
//    }
//    Log.i("two", names)
                    if (!isThereChannelsForMono()){
                        channel = Channel(number = channelList.size + 1)
                        channelList.add(channel)
                    }
                    for (cn in channelList){
                        if (cn.name == "---"){
                            channel = Channel(name = instrument.name + "1 m nfc",
                                number = cn.number,
                                pickup = instrument.pickup)
                            channelList.removeAt(channelList.indexOf(cn))
                            channelList.add(channel.number - 1, channel)
                            channelNumber = channel.number + 1
                            break
                        }
                    }
                }
            }
        }

    }
}
fun isThereChannelsForMono(): Boolean {
    var count = 0
    for (c in channelList){
        if (c.name == "---"){
            count ++
        }
    }

    return (count > 0)
}
fun isThereChannelsForStereo(): Boolean {
    var count = 0
    for (c in channelList){
        if (c.name == "---" && channelList[channelList.indexOf(c) + 1].name == "---" && channelList.indexOf(c) % 2 == 0){
            count ++
        }
    }
    return count > 0
}

