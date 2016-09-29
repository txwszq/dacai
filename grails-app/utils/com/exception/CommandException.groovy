package com.exception

class CommandException extends RuntimeException {

    def errorCodeList = []

    CommandException(){
        super()
    }

    CommandException(msg) {
        super(msg)
    }

    def addError(code) {
        errorCodeList.add(code)
    }

   def getErrors() {
       errorCodeList
   }
}
