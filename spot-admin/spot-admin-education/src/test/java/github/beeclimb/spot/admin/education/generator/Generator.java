package github.beeclimb.spot.admin.education.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.SQLException;

/**
 * @author jun.ma
 * @date 2022/6/6 16:23:00
 */
public class Generator {
    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://47.101.50.78:3306/spot", "root", "root")
            .build();

    /**
     * 全局配置
     */
    private static GlobalConfig globalConfig() {
        return new GlobalConfig.Builder()
                .outputDir("D:\\projects\\spot\\spot-admin\\spot-admin-education\\src\\test\\generatorcode")
                .author("baomidou")
                .enableSwagger()
                .dateType(DateType.ONLY_DATE)
                .commentDate("yyyy-MM-dd")
                .build();
    }

    /**
     * 包配置
     */
    private static PackageConfig packageConfig() {
        return new PackageConfig.Builder()
                .parent("github.beeclimb.spot.admin.education")
                .build();
    }

    /**
     * 策略配置
     */
    private static StrategyConfig strategyConfig() {
        return new StrategyConfig.Builder()
                .addInclude("edu_subject")
                .addTablePrefix("edu_")
                .serviceBuilder()
                .formatServiceFileName("%sService")
                .entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
                .build();
    }



    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        // data source config
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        // global config
        generator.global(globalConfig());
        // package config
        generator.packageInfo(packageConfig());
        // strategy config
        generator.strategy(strategyConfig());

        generator.execute();
    }


}
