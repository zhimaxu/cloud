package com.zhimaxu.common.core.constant;/*
 * @author xxc
 * @date 2024/4/25 下午3:02
 */

public class CacheConstants {
    /**
     * 缓存有效期，默认720（分钟）
     */
    public final static long EXPIRATION = 720;

    /**
     * 缓存刷新时间，默认60（分钟）
     */
    public final static long REFRESH_TIME = 60;

    /**
     * 密码最大错误次数
     */
    public final static int PASSWORD_MAX_RETRY_COUNT = 5;

    /**
     * 密码锁定时间，默认15（分钟）
     */
    public final static long PASSWORD_LOCK_TIME = 15;

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";
    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 登录IP黑名单 cache key
     */
    public static final String SYS_LOGIN_BLACK_IP_LIST = SYS_CONFIG_KEY + "sys.login.blackIPList";
}
