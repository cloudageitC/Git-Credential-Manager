class GitCredentialManager < Formula
  desc "Stores Git credentials for Visual Studio Team Services"
  homepage "${project.url}"
  url "https://github.com/Microsoft/Git-Credential-Manager-for-Mac-and-Linux/releases/download/git-credential-manager-${version}/git-credential-manager-${version}.jar"
  sha256 "TODO: insert SHA-256 of JAR here"

  bottle :unneeded

  if MacOS.version >= :el_capitan
    depends_on :java => "1.8+"
  else
    depends_on :java => "1.7+"
  end

  def install
    libexec.install "git-credential-manager-#{version}.jar"
    bin.write_jar_script libexec/"git-credential-manager-#{version}.jar", "git-credential-manager"
  end

  test do
    system "#{bin}/git-credential-manager", "version"
  end
end
