package cn.jpy.daoyun_end.repository;

import cn.jpy.daoyun_end.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
