package com.finers.invoicing.utils;


import com.finers.invoicing.common.Reply;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author 作者
 * @remark Reply工具类
 */
public final class ReplyUtil {

    /**
     * 成功200
     */
    private static final Reply successReply = new Reply();
    /**
     * 失败400
     */
    private static final Reply failReply = new Reply();
    /**
     * 非法4XX
     */
    private static final Reply noAuthReply = new Reply();
    private static final Reply invalidTokenReply = new Reply();
    private static final Reply invalidParamReply = new Reply();
    private static final Reply invalidAccountReply = new Reply();
    private static final Reply forbidReply = new Reply();
    private static final Reply overloadReply = new Reply();
    private static final Reply notExistReply = new Reply();
    private static final Reply invalidEmailReply = new Reply();
    private static final Reply tooOftenReply = new Reply();
    private static final Reply invalidPhoneReply = new Reply();
    private static final Reply accountExistReply = new Reply();
    private static final Reply invalidPasswordReply = new Reply();
    private static final Reply invalidCodeReply = new Reply();
    private static final Reply expiredTokenReply = new Reply();
    /**
     * 错误500
     */
    private static final Reply errorReply = new Reply();

    static {
        //success
        successReply.setCode(200);
        successReply.setMessage("请求成功");
        successReply.setSuccess(true);

        //success
        successReply.setCode(200);
        successReply.setMessage("请求成功");
        successReply.setSuccess(true);

        //error
        failReply.setCode(400);
        failReply.setMessage("请求失败");
        failReply.setSuccess(false);

        //
        noAuthReply.setCode(403);
        noAuthReply.setMessage("未授权");
        noAuthReply.setSuccess(false);

        //online overload
        overloadReply.setCode(410);
        overloadReply.setMessage("此账户在线人数超出上线");
        overloadReply.setSuccess(false);

        //invalid account
        invalidAccountReply.setCode(411);
        invalidAccountReply.setMessage("非法的账户名");
        invalidAccountReply.setSuccess(false);

        //account exist
        accountExistReply.setCode(412);
        accountExistReply.setMessage("用户名已被注册");
        accountExistReply.setSuccess(false);

        //forbidden
        forbidReply.setCode(413);
        forbidReply.setMessage("账户被禁止");
        forbidReply.setSuccess(false);

        //user not found
        notExistReply.setCode(414);
        notExistReply.setMessage("用户不存在");
        notExistReply.setSuccess(false);

        //invalid password
        invalidPasswordReply.setCode(420);
        invalidPasswordReply.setMessage("密码错误");
        invalidPasswordReply.setSuccess(false);

        //invalid token
        invalidTokenReply.setCode(421);
        invalidTokenReply.setMessage("无效凭证");
        invalidTokenReply.setSuccess(false);

        //expired token
        expiredTokenReply.setCode(422);
        expiredTokenReply.setMessage("凭证过期，需刷新");
        expiredTokenReply.setSuccess(false);

        //invalid code
        invalidCodeReply.setCode(423);
        invalidCodeReply.setMessage("验证码错误");
        invalidCodeReply.setSuccess(false);

        //invalid param
        invalidParamReply.setCode(430);
        invalidParamReply.setMessage("无效参数");
        invalidParamReply.setSuccess(false);

        //invalid phone
        invalidPhoneReply.setCode(431);
        invalidPhoneReply.setMessage("手机格式不正确");
        invalidPhoneReply.setSuccess(false);

        //invalid email
        invalidEmailReply.setCode(432);
        invalidEmailReply.setMessage("邮箱格式不正确");
        invalidEmailReply.setSuccess(false);

        //请求过于频繁
        tooOftenReply.setCode(490);
        tooOftenReply.setMessage("您请求过于频繁，请稍后重试！");
        tooOftenReply.setSuccess(false);

        //error
        errorReply.setCode(500);
        errorReply.setMessage("服务器错误");
        errorReply.setSuccess(false);
    }

    /**
     * 请求成功
     *
     * @return Reply
     */
    public static Reply success() {
        return successReply;
    }

    /**
     * 请求成功
     *
     * @param data 数据
     * @return Reply
     */
    public static Reply success(Object data) {
        try {
            Reply reply = (Reply) BeanUtils.cloneBean(successReply);
            reply.setData(data);

            return reply;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 请求成功
     *
     * @param data   数据
     * @param option 选项
     * @return Reply
     */
    public static Reply success(Object data, Object option) {
        try {
            Reply reply = (Reply) BeanUtils.cloneBean(successReply);
            reply.setData(data);
            reply.setOption(option);

            return reply;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 服务端错误
     *
     * @return Reply
     */
    public static Reply fail() {
        return failReply;
    }

    public static Reply fail(String msg) {
        return message(msg, failReply);
    }

    /**
     * 在线人数超载
     *
     * @return Reply
     */
    public static Reply noAuth() {
        return noAuthReply;
    }

    /**
     * 在线人数超载
     *
     * @return Reply
     */
    public static Reply overload() {
        return overloadReply;
    }

    /**
     * 用户不存在
     *
     * @return Reply
     */
    public static Reply notExist() {
        return notExistReply;
    }

    /**
     * 用户不存在
     *
     * @param msg 消息
     * @return Reply
     */
    public static Reply notExist(String msg) {
        return message(msg, invalidParamReply);
    }

    /**
     * 非法账户
     *
     * @return Reply
     */
    public static Reply accountExist() {
        return accountExistReply;
    }

    /**
     * 非法账户
     *
     * @return Reply
     */
    public static Reply invalidAccount() {
        return invalidAccountReply;
    }

    /**
     * 禁止访问
     *
     * @return Reply
     */
    public static Reply forbid() {
        return forbidReply;
    }

    /**
     * 非法口令
     *
     * @return Reply
     */
    public static Reply invalidPassword() {
        return invalidPasswordReply;
    }

    /**
     * 非法口令
     *
     * @param msg 消息
     * @return Reply
     */
    public static Reply invalidPassword(String msg) {
        return message(msg, invalidPasswordReply);
    }

    /**
     * 非法token
     *
     * @return Reply
     */
    public static Reply invalidToken() {
        return invalidTokenReply;
    }

    /**
     * token过期
     *
     * @return Reply
     */
    public static Reply expiredToken() {
        return expiredTokenReply;
    }

    /**
     * 非法code
     *
     * @return Reply
     */
    public static Reply invalidCode() {
        return invalidCodeReply;
    }

    /**
     * 无效参数
     *
     * @return Reply
     */
    public static Reply invalidParam() {
        return invalidParamReply;
    }

    /**
     * 无效参数
     *
     * @param msg 消息
     * @return Reply
     */
    public static Reply invalidParam(String msg) {
        return message(msg, invalidParamReply);
    }

    /**
     * 非法电话号码
     *
     * @return Reply
     */
    public static Reply invalidPhone() {
        return invalidPhoneReply;
    }

    /**
     * 非法email
     *
     * @return Reply
     */
    public static Reply invalidEmail() {
        return invalidEmailReply;
    }

    /**
     * 请求过于频繁
     *
     * @return Reply
     */
    public static Reply tooOften() {
        return tooOftenReply;
    }

    /**
     * 请求过于频繁
     *
     * @param obj 数据对象
     * @return
     */
    public static Reply tooOften(Object obj) {
        try {
            Reply reply = (Reply) BeanUtils.cloneBean(tooOftenReply);
            reply.setData(obj);

            return reply;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 服务端错误
     *
     * @return Reply
     */
    public static Reply error() {
        return errorReply;
    }

    /**
     * 给reply添加提示信息
     *
     * @param msg   消息
     * @param reply 需要进一步包装的Reply
     * @return Reply
     */
    public static Reply message(String msg, Reply reply) {
        try {
            Reply r = (Reply) BeanUtils.cloneBean(reply);
            r.setMessage(msg);

            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}