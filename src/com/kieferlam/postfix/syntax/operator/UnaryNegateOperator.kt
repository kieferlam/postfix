package com.kieferlam.postfix.syntax.operator

import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.Operator

class UnaryNegateOperator internal constructor() : Operator(1, "-") {

    override fun getPrecedence() = 4

    override fun operate(vararg operands: Operand): Operand {
        return Operand(operands[0].value.negate())
    }

    override fun toString() = "UnaryMinus"
}