package ru.innopolis.stc31.appeal.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.exceptions.ErrorMessage;
import ru.innopolis.stc31.appeal.exceptions.HashAlgorithmError;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@Slf4j
@Component
public class AppealPasswordEncoder implements PasswordEncoder {

    @Value("${config.security.secret}")
    private String secret;

    private static final PasswordEncoder INSTANCE = new AppealPasswordEncoder();

    public AppealPasswordEncoder() {
        // Do nothing
    }

    @SneakyThrows
    @Override
    public String encode(CharSequence rawPassword) {
        return getMd5Hash(rawPassword.toString()+secret);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String rawPasswordHashMD5 = (rawPassword.toString().toLowerCase(Locale.ROOT)+secret);
        return rawPasswordHashMD5.equals(encodedPassword);
    }

    /**
     * Get the singleton.
     */
    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

    public String getMd5Hash(String source) throws HashAlgorithmError {
        try {
            var md = MessageDigest.getInstance("SHA-1");
            md.update(source.getBytes());
            byte[] digest = md.digest();
            return bytesToHex(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            ErrorMessage errorMessage = new ErrorMessage(-3,
                    "Не удалось вычислить hash значения(неподдерживаемый алгоритм)");
            log.error(errorMessage.toString());
            throw new HashAlgorithmError(errorMessage);
        }
    }

    private String bytesToHex(byte[] bytes) {
        var builder = new StringBuilder();
        for (var b : bytes) {
            builder.append(String.format("%02x", b & 0xff));
        }
        return builder.toString();
    }



}
