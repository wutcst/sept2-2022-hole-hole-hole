package cn.lkpttxg.sept2.worldofzuul.bean;

import cn.lkpttxg.sept2.worldofzuul.common.enums.resultCode.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author TXG
 * @date 2022/6/28$
 *
 * 用于与客户端交互的
 * ResponseData为控制层返回给前端的信息，标准写法
 * 是该节点后台返回的数据类型。
 */
@ApiModel(description = "标准的后台响应数据")
@Getter
@Accessors(chain=true)
public class ResponseData<T> {

    @ApiModelProperty(value = "目前版本",required = true,dataType = "String",example = "v1.0,v1.1")
    private String version;
    @ApiModelProperty(value = "响应状态码",required = true,dataType = "int",example = "200,400,404,501")
    private int code;
    @ApiModelProperty(value = "响应状态说明",required = true,dataType = "String")
    private String message;
    @ApiModelProperty(value = "响应数据：json格式")
    private T data;

    //set返回this可以连续赋值
    public ResponseData<T> setCode(ResultCode resultCode) {
        //赋值状态码
        this.code = resultCode.code;
        return this;
    }

    public ResponseData<T> setVersion(String version) {
        this.version = version;
        return this;
    }

    public ResponseData<T>setCode(int code) {
        this.code = code;
        return this;
    }

    public ResponseData<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseData<T> setData(T data) {
        this.data = data;
        return this;
    }
}
