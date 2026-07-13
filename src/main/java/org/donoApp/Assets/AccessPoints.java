package org.donoApp.Assets;

/**
 * AWS credentials are resolved via the standard AWS SDK provider chain
 * (environment variables, ~/.aws/credentials, or an instance/task role) —
 * never hardcoded here. Set AWS_REGION plus either AWS_ACCESS_KEY_ID /
 * AWS_SECRET_ACCESS_KEY or a local AWS CLI profile before running.
 */
public class AccessPoints {

    public static void awsProperty() {
        String region = System.getenv("AWS_REGION");
        if (region == null || region.isBlank()) {
            throw new IllegalStateException(
                "AWS_REGION is not set. Configure your AWS credentials/region " +
                "(env vars or ~/.aws/credentials) before running the app."
            );
        }
        System.setProperty("aws.region", region);
    }
}
