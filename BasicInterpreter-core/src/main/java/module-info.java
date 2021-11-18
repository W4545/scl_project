module dev.jacaro.basicinterpreter.core {

    requires kotlin.stdlib;
    requires kotlin.reflect;

    exports dev.jacaro.school.cs4308.errors;
    exports dev.jacaro.school.cs4308.structure;
    exports dev.jacaro.school.cs4308.commands;
    exports dev.jacaro.school.cs4308.constants;
    exports dev.jacaro.school.cs4308.errors.constraints;
    exports dev.jacaro.school.cs4308.values;
    exports dev.jacaro.school.cs4308.expressions;
    exports dev.jacaro.school.cs4308.ids;
}