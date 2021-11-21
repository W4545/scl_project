module dev.jacaro.basicinterpreter.core {

    requires kotlin.stdlib;
    requires kotlin.reflect;

    exports dev.jacaro.school.cs4308.java.errors;
    exports dev.jacaro.school.cs4308.java.structure;
    exports dev.jacaro.school.cs4308.kotlin.commands;
    exports dev.jacaro.school.cs4308.kotlin.constants;
    exports dev.jacaro.school.cs4308.kotlin.errors.constraints;
    exports dev.jacaro.school.cs4308.kotlin.errors;
    exports dev.jacaro.school.cs4308.kotlin.structure;
    exports dev.jacaro.school.cs4308.kotlin.values;
    exports dev.jacaro.school.cs4308.kotlin.expressions;
    exports dev.jacaro.school.cs4308.kotlin.ids;
}