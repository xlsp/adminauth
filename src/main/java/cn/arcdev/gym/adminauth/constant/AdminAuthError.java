package cn.arcdev.gym.adminauth.constant;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Error codes and messages of admin auth module.
 *
 * @author Kraken
 */
@AllArgsConstructor
public class AdminAuthError {
    private static final int BASE_LINE = 10010000;
    /**
     * Did not set a default role for new user.
     */
    public static final int NO_DEFAULT_ROLE = BASE_LINE+1;

    public static final String NO_DEFAULT_ROLE_MESSAGE = "系统未设置默认角色";
}
