package uz.klimuz.in_outlist.utils
fun countChannelsForInstrumentsInTheGroup(list: ArrayList<Instrument>): Int{
    var counter = 0
    for (i in list){
        if (i.isStereo) {
            counter += i.quantity * 2
        }else{
            counter += i.quantity
        }
    }
    return counter
}
fun countAllChannels(): Int{
    var  counter = 0
    counter = countChannelsForInstrumentsInTheGroup(drumInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(percussionInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(guitarInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(keyboardInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(nationalInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(soloistInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(backVocalInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(stringInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(woodwindInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(brassInstrumentsList) +
            countChannelsForInstrumentsInTheGroup(playbackInstrumentsList)

    return counter
}