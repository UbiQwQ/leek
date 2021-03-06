package com.atong.leek;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: leek
 * @description: mybatis逆向工程代码生成器
 * @author: atong
 * @create: 2020-12-17 16:38
 */
public class Generator {
    public void generator() throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指定 逆向工程配置文件
        File configFile = new File("leek-mybatis-generator/src/main/resources/generatorConfig.xml");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.length());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

        System.err.println("------------------------------info-----------------------------");
        System.err.println("创建成功!! 欢迎下次使用!");
        System.err.println("------------------------------------------------------------------");

    }

    public static void main(String[] args) throws Exception {
        try {
            Generator generator = new Generator();
            generator.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
