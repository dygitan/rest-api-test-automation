(function() {
    karate.configure("ssl", true);
    karate.configure('connectTimeout', 30000);
    karate.configure('readTimeout', 30000);

    var env = karate.env;

    if (!env) {
        env = 'dev';
    }

    var config = {
        env: env,
        baseUrl: 'http://localhost:8080',
        expectedStatus: 200
    };

    return config;
})