object Versions {
  val braveVersion = "5.5.0"
  val conscrypt = "1.4.1"
  val jackson = "2.9.7"
  val jjwtVersion = "0.10.5"
  val junitVersion = "5.3.1"
  val kotlin = "1.3.10"
  val kotlinCoroutines = "1.0.1"
  val moshiVersion = "1.8.0"
  val okhttpVersion = "3.12.0"
  val oksocialOutputVersion = "4.24.0"
  val slf4jVersion = "1.8.0-beta2"
}

object Deps {
  val activation = "javax.activation:activation:1.1.1"
  val airline = "com.github.rvesse:airline:2.6.0"
  val bouncyCastle = "org.bouncycastle:bcprov-jdk15on:1.60"
  val brave = "io.zipkin.brave:brave:${Versions.braveVersion}"
  val braveInstrumentationOkhttp3 = "io.zipkin.brave:brave-instrumentation-okhttp3:${Versions.braveVersion}"
  val braveOkhttp3 = "io.zipkin.brave:brave-okhttp:4.13.6"
  val brotli = "org.brotli:dec:0.1.2"
  val byteunits = "com.jakewharton.byteunits:byteunits:0.9.1"
  val commonsIo = "commons-io:commons-io:2.6"
  val commonsLang = "org.apache.commons:commons-lang3:3.8.1"
  val conscryptUber = "org.conscrypt:conscrypt-openjdk-uber:${Versions.conscrypt}"
  val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
  val coroutinesJdk8 = "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${Versions.kotlinCoroutines}"
  val jacksonCbor = "com.fasterxml.jackson.dataformat:jackson-dataformat-cbor:${Versions.jackson}"
  val jacksonDatabind = "com.fasterxml.jackson.core:jackson-databind:${Versions.jackson}"
  val jacksonJdk8 = "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:${Versions.jackson}"
  val jacksonJsr310 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Versions.jackson}"
  val jacksonKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}"
  val jacksonParams = "com.fasterxml.jackson.module:jackson-module-parameter-names:${Versions.jackson}"
  val jacksonYaml = "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${Versions.jackson}"
  val jansi = "org.fusesource.jansi:jansi:1.17.1"
  val jffi = "com.github.jnr:jffi:1.2.18"
  val jjwt = "io.jsonwebtoken:jjwt-api:${Versions.jjwtVersion}"
  val jjwtImpl = "io.jsonwebtoken:jjwt-impl:${Versions.jjwtVersion}"
  val jjwtJackson = "io.jsonwebtoken:jjwt-jackson:${Versions.jjwtVersion}"
  val jkeychain = "pt.davidafsilva.apple:jkeychain:1.0.0"
  val jnrUnixSocket = "com.github.jnr:jnr-unixsocket:0.20"
  val jsr305 = "com.google.code.findbugs:jsr305:3.0.2"
  val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junitVersion}"
  val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junitVersion}"
  val kotlinCompilerEmbeddable = "org.jetbrains.kotlin:kotlin-compiler-embeddable:${Versions.kotlin}"
  val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
  val kotlinScriptUtil = "org.jetbrains.kotlin:kotlin-script-util:${Versions.kotlin}"
  val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
  val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
  val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
  val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
  val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshiVersion}"
  val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
  val nettyResolveDns = "io.netty:netty-resolver-dns:4.1.30.Final"
  val ok2Curl = "com.github.mrmike:ok2curl:0.4.5"
  val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
  val okhttpDigest = "com.baulsupp:okhttp-digest:0.4.0"
  val okhttpDoh = "com.squareup.okhttp3:okhttp-dnsoverhttps:${Versions.okhttpVersion}"
  val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
  val okhttpMWS = "com.squareup.okhttp3:mockwebserver:${Versions.okhttpVersion}"
  val okhttpSse = "com.squareup.okhttp3:okhttp-sse:${Versions.okhttpVersion}"
  val okhttpTesting = "com.squareup.okhttp3:okhttp-testing-support:${Versions.okhttpVersion}"
  val okhttpTls = "com.squareup.okhttp3:okhttp-tls:${Versions.okhttpVersion}"
  val okhttpUDS = "com.squareup.okhttp3.sample:unixdomainsockets:${Versions.okhttpVersion}"
  val okio = "com.squareup.okio:okio:2.1.0"
  val oksocialOutput = "com.baulsupp:oksocial-output:${Versions.oksocialOutputVersion}"
  val proxyVol = "com.github.markusbernhardt:proxy-vole:1.0.5"
  val slf4jApi = "org.slf4j:slf4j-api:${Versions.slf4jVersion}"
  val slf4jJdk14 = "org.slf4j:slf4j-jdk14:${Versions.slf4jVersion}"
  val tink = "com.google.crypto.tink:tink:1.2.1"
  val zipkin = "io.zipkin.java:zipkin:2.10.1"
  val zipkinSenderOkhttp3 = "io.zipkin.reporter2:zipkin-sender-okhttp3:2.7.10"
  val ztExec = "org.zeroturnaround:zt-exec:1.10"
}
