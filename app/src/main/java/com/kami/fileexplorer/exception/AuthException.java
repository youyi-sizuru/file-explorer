package com.kami.fileexplorer.exception;

import java.io.IOException;

/**
 * author: youyi_sizuru
 * data: 2017/8/13
 */

public class AuthException extends IOException {

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
