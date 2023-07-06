# toSQL
Mybatis XML 转换为 SQL语句, 欢迎大家提供想法一起完善❤️

## 使用方法
1. 可以在IDEA plugin 中搜索 toSQL
2. 使用源码编译后的jar, 在IDEA plugin 中添加
3. 在releases中下载jar文件

## 转换效果展示

```xml
  <select id="findPage" parameterType="map" resultMap="BaseResultMap">
    select * from c AS c
    <where>
      and deleted = '0'
      <if test="name!=null">
        and c.name LIKE CONCAT('%', #{name,jdbcType=VARCHAR}, '%')
      </if>

      <if test="pageStatus!=null">
        and c.page_status = #{pageStatus,jdbcType=INTEGER}
      </if>
      <if test="startTime != null and startTime!=''">
        and c.start_time &gt;=  #{startTime}
      </if>

      <if test="endTime != null and endTime!='' ">
        and c.end_time  &lt;=  #{endTime}
      </if>
    </where>
      ORDER BY c.add_time desc,c.update_time desc
  </select>
```

转换后

```SQL
SELECT
	* 
FROM
	dts_component_page c 
WHERE
	deleted = '0'
	AND deleted = '0' 
	AND c.NAME LIKE concat( '%', '', '%' ) 
	AND c.page_status = '' 
	AND c.start_time >= '' 
	AND c.end_time <= '' 
ORDER BY
	c.add_time DESC,
	c.update_time DESC
```



<img width="785" alt="image" src="https://github.com/huxuekuo/toSQL/assets/41356055/88b79cdb-76f1-44f2-954e-7b6aaeb97a71">
