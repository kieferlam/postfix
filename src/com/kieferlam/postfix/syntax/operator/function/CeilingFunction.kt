package com.kieferlam.postfix.syntax.operator.function

import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.bd

class CeilingFunction internal constructor() : FunctionOperator("ceil",1) {

    override fun operate(vararg operands: Operand): Operand {
        return Operand((Math.ceil(operands[0].value.toDouble())).bd)
    }

    override fun toString(): String = "Ceiling"
}