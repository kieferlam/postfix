package com.kieferlam.postfix.syntax.operator

import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.Operator

class PowerOperator internal constructor() : Operator(2, "^") {

    override fun getPrecedence() = 2

    override fun operate(vararg operands: Operand): Operand {
        return Operand(Math.pow(operands[0].value.toDouble(), operands[1].value.toDouble()).toBigDecimal())
    }

    override fun toString() = "Power"
}