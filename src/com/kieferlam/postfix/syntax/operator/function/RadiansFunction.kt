package com.kieferlam.postfix.syntax.operator.function

import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.bd

class RadiansFunction internal constructor() : FunctionOperator("rad",1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((Math.toRadians(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "ToRadians"
}