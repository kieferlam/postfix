package com.kieferlam.postfix.syntax.operator.function

import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.bd

class FloorFunction internal constructor() : FunctionOperator("floor", 1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((Math.floor(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "Floor"
}