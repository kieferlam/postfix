# Postfix
Postfix is a mathematical expression evaluator built with Kotlin (compatible with Java). Postfix provides an easy way to evaluate string representations of basic mathematical expressions.

# Usage

## Converting string to `Expression`
Postfix uses an `Expression` object to store the expression in a format Postfix can understand. To convert a string to an `Expression`, you can use `Postfix.from(myString)`.
### Java
```Java
String expressionAsString = "5/(4+2)";
Expression expression = Postfix.from(expressionAsString);
```
### Kotlin
```Kotlin
val expressionAsString = "5/(4+2)"
val expression = Postfix.from(expressionAsString)
```

## Evaluating an `Expression`
Evaluating an `Expression` will give you a single `Operand` as a result. `Operand` has a `value` member of type `BigDecimal`.

To evaluate a valid `Expression`, use `Postfix.evaluate(Expression)`.

### Java
```Java
Expression myExpression = Postfix.from("5/(4+2)");
Operand result = Postfix.evaluate(myExpression);
BigDecimal value = result.value;
```

### Kotlin
```Kotlin
val myExpression = Postfix.from("5/(4+2)")
val result = Postfix.evaluate(myExpression)
val value = result.value
```

## Operators

1. **\+** Plus
2. **\-** Minus
3. **\-** UnaryMinus
4. __*__ Multiply
5. **/** Divide
6. **^** Exponent
7. **()** Brackets
8. **%** Modulus
9. Functions
    1. **sqrt()** Square Root
    2. Trigonometry
        1. **sin()** Sine
        2. **cos()** Cosine
        3. **tan()** Tangent
        4. **asin()** Inverse Sine
        5. **acos()** Inverse Cosine
        6. **atan()** Inverse Tangent
    3. **rad()** Radians
    4. **deg()** Degrees
    5. **abs()** Absolute Value
    6. **ceil()** Ceiling
    7. **floor()** Floor
    8. **round()** Round


# Under the hood
## Expression
The `Expression` class inherits `ArrayList<ExpressionEntity>` so you'll be able to use all the default methods present in `ArrayList` such as `ArrayList<T>.add(T)`. This means you'll also be able to iterate through the `Expression` like a regular `ArrayList`. 

Since `Operand` and `Operator` both inherit `ExpressionEntity`, you'll be able to add objects of those types into the `Expression`. However this is not recommended as the `Expression` may become an invalid *Postfix* `Expression` if you add `Operand`s or `Operator`s.

## Postfix conversion
An `Expression` object can be either an `Infix` `Expression` or a `Postfix` `Expression`. The difference is determined by the order of the entities in the `Expression` object. 

For example, `Postfix.from(String)` will return an `Expression` in `Postfix` notation however `Postfix.scan(String)` will return an `Expression` in `Infix` notation.

When evaluating, you *must* provide a valid `Postfix` `Expression` in order for `Postfix` to evaluate the `Expression` properly.

To convert an `Infix` `Expression` into a `Postfix` `Expression`, simply use `Postfix.toPostfix(Expression)`.

### Java
```Java
Expression infix = Postfix.scan("5/(4+2)");
Expression postfix = Postfix.toPostfix(infix);
Operand result = Postfix.evaluate(postfix);
```

### Kotlin
```Kotlin
val infix = Postfix.scan("5/(4+2)")
val postfix = Postfix.toPostfix(infix)
val result = Postfix.evaluate(postfix)
```