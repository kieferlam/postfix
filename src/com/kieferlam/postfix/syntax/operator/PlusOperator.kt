package com.kieferlam.postfix.syntax.operator

import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.Operator

class PlusOperator internal constructor() : Operator(2, "+") {

    override fun getPrecedence() = 0
    
    override fun operate(vararg operands: Operand): Operand {
        return Operand(operands[0].value.plus(operands[1].value))
    }

    override fun toString() = "Plus"
}