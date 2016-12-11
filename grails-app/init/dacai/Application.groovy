package dacai

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import java.nio.file.Files

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

}