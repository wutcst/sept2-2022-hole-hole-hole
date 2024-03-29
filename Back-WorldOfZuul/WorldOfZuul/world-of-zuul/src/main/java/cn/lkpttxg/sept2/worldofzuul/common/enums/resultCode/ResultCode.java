package cn.lkpttxg.sept2.worldofzuul.common.enums.resultCode;

/**
 * @author TXG
 * @date 2022/6/28$
 */
public enum ResultCode {
    //成功
    SUCCESS(200),
    //没死
    CONTINUE(201),
    //获得传送房间
    MIDDLE(300),
    //失败
    FAIL(400),
    //未认证（签名错误）
    UNAUTHORIZED(401),
    //没有登录
    NO_LOGIN(402),
    //没有权限
    NO_PERMISSION(403),
    //接口不存在
    NOT_FOUND(404),
    //用户状态异常、公司状态异常、产品状态异常
    STATE_ERROR(406),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(500),
    //玩家死亡
    PLAYER_DIED(501),
    //参数错误
    PARAMETER_ERROR(10001),
    //账号错误
    ACCOUNT_ERROR(20001),
    //登录失败
    LOGIN_FAIL_ERROR(20002);


    //返回状态码
    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
