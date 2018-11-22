# 使用说明
- cd archetype
- mvn archetype:create-from-project -Darchetype.filteredExtensions=java
- cd target/generated-sources/archetype/
- mvn install

# 参考
[Create an archetype from a multi-module project](http://maven.apache.org/archetype/maven-archetype-plugin/examples/create-multi-module-project.html)