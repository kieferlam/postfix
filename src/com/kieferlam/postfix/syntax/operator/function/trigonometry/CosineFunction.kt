package com.kieferlam.postfix.syntax.operator.function.trigonometry

import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.bd
import com.kieferlam.postfix.syntax.operator.function.FunctionOperator

class CosineFunction internal constructor() : FunctionOperator("cos",1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((Math.cos(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "Cosine"
}