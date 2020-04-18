package br.pucminas.tcc.sica.seguranca.infra;

import java.lang.reflect.Method;

import org.slf4j.*;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        LOGGER.error("Erro na execução do método {} com parâmetros:\n{}", method.getName(), params, ex);
    }
}
