package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * @author Chuan
 */
public class MaxPointsOnALine
{
    /**
     * 解法一：这些给定点两两之间都可以算一个斜率，每个斜率代表一条直线，对每一条直线，
     * 带入所有的点看是否共线并计算个数，这是整体的思路。
     * @param points
     * @return
     */
    public int maxPoints(Point[] points)
    {
        int res = 0;
        for (int i = 0; i < points.length; ++i)
        {
            //记录重合点的个数
            int duplicate = 1;
            Map<Double, Integer> m = new HashMap<>();
            for (int j = i + 1; j < points.length; ++j)
            {
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                {
                    ++duplicate;
                }
                //那么当x1 = x2时斜率不存在,斜率用最大值代替
                else if (points[i].x == points[j].x)
                {
                    m.put(Double.MAX_VALUE, m.getOrDefault(Double.MAX_VALUE, 0) + 1);
                }
                //那么当y1 = y2时斜率为0
                else if (points[i].y == points[j].y)
                {
                    m.put(0.0, m.getOrDefault(0.0, 0) + 1);
                }
                else
                {
                    double slope = (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
                    m.put(slope, m.getOrDefault(slope, 0) + 1);
                }
            }
            //如果没有这个，只有一个点时会报错
            res = Math.max(res, duplicate);
            for (Map.Entry<Double, Integer> e : m.entrySet())
            {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }

    /**
     * 解法2：由于通过斜率来判断共线需要用到除法，而用double表示的双精度小数在有的系统里不一定准确，为了更加精确无误的计算共线，
     * 我们应当避免除法，从而避免无线不循环小数的出现，那么怎么办呢，我们把除数和被除数都保存下来，不做除法，但是我们要让这两数分别除以它们的最大公约数，
     * 这样例如8和4，4和2，2和1，这三组商相同的数就都会存到一个映射里面，同样也能实现我们的目标，
     * 而求GCD的函数如果用递归来写那么一行就搞定了
     * @param points
     * @return
     */
    public int maxPoints2(Point[] points)
    {
        int res = 0;
        for (int i = 0; i < points.length; ++i)
        {
            //记录重合点的个数
            int duplicate = 1;
            Map<Map<Integer,Integer>, Integer> m = new HashMap<>();
            for (int j = i + 1; j < points.length; ++j)
            {
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                {
                    ++duplicate;
                    continue; //执行下一次循环
                }
                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                int d = gcd(dx, dy);
                Map<Integer, Integer> t = new HashMap<>();
                t.put(dx / d, dy / d);
                m.put(t, m.getOrDefault(t, 0) + 1);
            }
            //如果没有这个，只有一个点时会报错
            res = Math.max(res, duplicate);
            for (Map.Entry<Map<Integer, Integer>, Integer> e : m.entrySet())
            {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }

    public int gcd(int a, int b)
    {
        return (b == 0)? a :gcd(b, a % b);
    }
}


  class Point
  {
      int x;
      int y;
      Point()
      {
          x = 0; y = 0;
      }
      Point(int a, int b)
      {
          x = a; y = b;
      }
  }

