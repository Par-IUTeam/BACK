package com.pariuteam.back.responseBodies;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Mapper<Base,New>{

    public abstract New toDomain(Base base);

    public List<New> toDomain(List<Base> bases){
        return bases.stream().map(baseObject->toDomain(baseObject)).collect(Collectors.toList());
    }
}
