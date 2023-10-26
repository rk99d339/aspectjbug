package com.example.aspectmockitobug;


public aspect Aspect {

    public pointcut authorization(Object owner):target(owner) && (
            execution(public void *.set*(..)) && @within(MakeSecuredObject)            );

    before(Object owner): authorization(owner) {
        Class<?> clazz = thisJoinPointStaticPart.getSignature().getDeclaringType();
        String methodName = thisJoinPointStaticPart.getSignature().getName();
    }
}