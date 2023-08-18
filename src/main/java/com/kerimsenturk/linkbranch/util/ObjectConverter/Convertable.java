package com.kerimsenturk.linkbranch.util.ObjectConverter;

public interface Convertable <Input, Output>{
    Output convert(Input input);
    Input deConvert(Output output);
}
