package com.kieferlam.postfix.testing

import com.kieferlam.postfix.syntax.Operand
import com.kieferlam.postfix.syntax.Postfix
import com.kieferlam.postfix.syntax.bd
import org.junit.Test
import java.lang.Math.*
import java.math.BigDecimal
import kotlin.math.sin
import kotlin.test.assertEquals

class PostfixTests{
    
    private fun assertExpression(expression: String, expected: BigDecimal){
        assertEquals(expected.toDouble(), Postfix.evaluate(Postfix.from(expression)).value.toDouble())
    }
    
    @Test
    fun evaluation(){
        assertExpression("4+2-3*3/2^5", 5.71875.bd)
    }
    
    @Test
    fun operandOnlyExpression(){
        assertExpression("4.12", 4.12.bd)
    }
    
    @Test
    fun evaluationWithFractions(){
        assertExpression("2.7*0.5", 1.35.bd)
        assertExpression("1.3+2.7*0.5", 2.65.bd)
    }
    
    @Test
    fun evaluationWithBrackets(){

        assertExpression("((3/2)*(4+3)-(2*0.5)+(0.25/0.5)", 10.0.bd)
    }
    
    @Test
    fun evaluationWithFunctions(){
        assertExpression("sin(0)", 0.0.bd)
        assertExpression("cos(0)", 1.0.bd)
        assertExpression("tan(0)", 0.0.bd)
        assertExpression("ceil(0.5)", 1.0.bd)
        assertExpression("floor(1.5)", 1.0.bd)
        assertExpression("round(1.5)", 2.bd)
        assertExpression("round(1.49)", 1.bd)
        assertExpression("sqrt(4)", 2.0.bd)
        assertExpression("sqrt(1.5625)", 1.25.bd)
        assertExpression("abs(-1.25)", 1.25.bd)
        assertExpression("invsin(0.5)", asin(0.5).bd)
        assertExpression("invcos(0.5)", acos(0.5).bd)
        assertExpression("invtan(0.5)", atan(0.5).bd)
    }
    
    @Test
    fun evaluationWithNestedFunctions(){
        assertExpression("cos(sin(0))", 1.0.bd)
        assertExpression("ceil(sin(0.1))", 1.0.bd)
        assertExpression("deg(sqrt((sin(4)/(cos(0.5)+1))^2)*1.25)", toDegrees(sqrt(pow(sin(4.0)/(cos(0.5)+1), 2.0))*1.25).bd)
        
    }
    
    @Test
    fun evaluationWithUnaryNegate(){
        assertExpression("-1.25", (-1.25).bd)
        assertExpression("abs(-5.1)", 5.1.bd)
        
    }
    
    @Test
    fun evaluationWithModulus(){
        assertExpression("5%2", 1.bd)
    }
    
}
