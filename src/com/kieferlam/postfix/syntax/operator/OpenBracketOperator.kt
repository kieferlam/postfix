package com.kieferlam.postfix.syntax.operator

import com.kieferlam.postfix.exception.NonOperationalOperatorException
import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.Operator

class OpenBracketOperator internal constructor() : Operator(0, "(") {
    override fun getPrecedence() = -1

    override fun operate(vararg operands: Operand): Operand {
        throw NonOperationalOperatorException("Open bracket operator does not have an operation.")
    }

    override fun toString() =  "OpenBracket"
}