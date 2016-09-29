package com.main

import com.exception.CommandException
import com.exception.InvalidOperateExcpetion
import grails.converters.JSON
import grails.validation.ValidationException
import org.springframework.security.core.context.SecurityContextHolder

import javax.servlet.http.HttpServletResponse
import java.sql.BatchUpdateException
import java.sql.SQLException

class AbstractController {

    def beforeInterceptor = {
        request.setCharacterEncoding("UTF-8")
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
    }
    /**
     * Render error response
     * @param msg
     * @return
     */
    protected renderErrorResponse(statusCode, errorMessage, errorCode) {
        response.status = statusCode
        Map data = [
                errorId: statusCode,
                errorMessage: errorMessage
        ]

        if (errorCode) {
            data.errorId = errorCode
        }

        JSON json = new JSON([error:data])
        render(json)
    }

    protected renderErrorResponse(statusCode, errorMessage) {
        renderErrorResponse(statusCode, errorMessage, null)
    }


    def buildSuccessResponse() {
        response.status = HttpServletResponse.SC_OK
        render(text: '{"success":true}', contentType: 'application/json')
    }

    def isInvalidOperate(args) {
        if (!args) {
            throw new InvalidOperateExcpetion()
        }
        args.each { arg ->
            if (arg == null) {
                throw new InvalidOperateExcpetion()
            }
        }
    }

    def getCurrentUser() {
       SecurityContextHolder.getContext().getAuthentication().getPrincipal()
    }

    def handleSQLException(SQLException e) {
        renderErrorResponse(HttpServletResponse.SC_BAD_REQUEST, e.message)
    }

    def handleBatchUpdateException(BatchUpdateException e) {
        renderErrorResponse(HttpServletResponse.SC_BAD_REQUEST, e.message)
    }

    def handleNumberFormatException(NumberFormatException nfe) {
        renderErrorResponse(HttpServletResponse.SC_BAD_REQUEST, nfe.message)
    }

    def handleInvalidOperateExcpetion(InvalidOperateExcpetion e) {
        renderErrorResponse(HttpServletResponse.SC_BAD_REQUEST, message(code:"error.invalid.operate", locale: Locale.SIMPLIFIED_CHINESE))
    }

    def handleCommandException(CommandException e) {
        def errors = e.errors
        if(errors?.size() > 0) {
            return renderErrorResponse(HttpServletResponse.SC_BAD_REQUEST, message(code:errors[0], locale: Locale.SIMPLIFIED_CHINESE))
        }
    }

    def handleValidationException(ValidationException e) {
        renderErrorResponse(HttpServletResponse.SC_BAD_REQUEST, message(code:e.errors.fieldError.defaultMessage, args: e.errors.fieldError.arguments, locale: Locale.SIMPLIFIED_CHINESE))
    }

    def handleException(Exception e) {
        renderErrorResponse(HttpServletResponse.SC_BAD_REQUEST, e.message)
    }

}
