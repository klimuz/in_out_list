package uz.klimuz.in_outlist.utils

var drumsActivityLaunchCounter: Int = 0
var percussionActivityLaunchCounter: Int = 0
var guitarsActivityLaunchCounter: Int = 0
var synthsActivityLaunchCounter: Int = 0
var nationalActivityLaunchCounter: Int = 0
var soloistsActivityLaunchCounter: Int = 0
var backVocalsActivityLaunchCounter: Int = 0
var stringsActivityLaunchCounter: Int = 0
var woodwindsActivityLaunchCounter: Int = 0
var brassActivityLaunchCounter: Int = 0
var playbackActivityLaunchCounter: Int = 0

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
fun countAllInstruments(): Int{
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