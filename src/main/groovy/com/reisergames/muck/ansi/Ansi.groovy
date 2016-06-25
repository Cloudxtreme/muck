package com.reisergames.muck.ansi

/**
 * Created by aeon on 6/24/2016.
 */
class Ansi {

    static def RESET = "\033[0m"
    static def BLINK = "\033[5m"
    static def UNDERSCORE = "\033[4m"

    static String parse(String input){
        input = input.replaceAll(/\^BLK\^/, "\033[1;30m")
        input = input.replaceAll(/\^RED\^/, "\033[1;31m")
        input = input.replaceAll(/\^GRN\^/, "\033[1;32m")
        input = input.replaceAll(/\^YLW\^/, "\033[1;33m")
        input = input.replaceAll(/\^BLU\^/, "\033[1;34m")
        input = input.replaceAll(/\^MAG\^/, "\033[1;35m")
        input = input.replaceAll(/\^CYN\^/, "\033[1;36m")
        input = input.replaceAll(/\^WHT\^/, "\033[1;37m")
        input = input.replaceAll(/\^blk\^/, "\033[0;30m")
        input = input.replaceAll(/\^red\^/, "\033[0;31m")
        input = input.replaceAll(/\^grn\^/, "\033[0;32m")
        input = input.replaceAll(/\^ylw\^/, "\033[0;33m")
        input = input.replaceAll(/\^blu\^/, "\033[0;34m")
        input = input.replaceAll(/\^mag\^/, "\033[0;35m")
        input = input.replaceAll(/\^cyn\^/, "\033[0;36m")
        input = input.replaceAll(/\^wht\^/, "\033[0;37m")
        return input+RESET
    }

}
