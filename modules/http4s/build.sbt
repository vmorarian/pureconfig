name := "pureconfig-http4s"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-core" % "0.18.0",
  Dependencies.scalaMacrosParadise,
  Dependencies.scalaTest
)

// http4s 0.18.0 isn't published for Scala 2.10
crossScalaVersions ~= { oldVersions => oldVersions.filterNot(_.startsWith("2.10")) }

pomExtra := {
  <developers>
    <developer>
      <id>jcranky</id>
      <name>Paulo Siqueira</name>
      <url>https://github.com/jcranky</url>
    </developer>
  </developers>
}

osgiSettings

OsgiKeys.exportPackage := Seq("pureconfig.modules.http4s.*")
OsgiKeys.privatePackage := Seq()
OsgiKeys.importPackage := Seq(s"""scala.*;version="[${scalaBinaryVersion.value}.0,${scalaBinaryVersion.value}.50)"""", "*")
