package com.kieferlam.postfix.syntax.operator

import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.Operator

class DivideOperator internal constructor() : Operator(2, "/") {

    override fun getPrecedence() = 1

    override fun operate(vararg operands: Operand): Operand {
        return Operand(operands[0].value.divide(operands[1].value, Operator.CONTEXT))
    }

    override fun toString() =  "\u00F7"
}