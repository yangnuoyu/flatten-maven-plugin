File originalPom = new File( basedir, 'pom.xml' )
assert originalPom.exists()

def originalProject = new XmlSlurper().parse( originalPom )
assert 0 ==  originalProject.dependencies.size()
assert 'java9' == originalProject.profiles.profile.id.text()
assert 2 == originalProject.profiles.profile.dependencies.dependency.size()

File flattendPom = new File( basedir, '.flattened-pom.xml' )
assert flattendPom.exists()

def flattendProject = new XmlSlurper().parse( flattendPom )
assert 0 ==  flattendProject.dependencies.size()
assert 2 ==  flattendProject.profiles.profile.dependencies.dependency.size()
assert '1.3.2' ==  flattendProject.profiles.profile.dependencies.dependency[0].version.text()
assert '1.1' ==  flattendProject.profiles.profile.dependencies.dependency[1].version.text()

