package com.imooc.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TestVo {
    @NotBlank
    private String msg;
    @NotNull
    @Max(value = 60, message = "age不能大于60")
    @Min(value = 18, message = "age不能小于18")
    private Integer age;
}
