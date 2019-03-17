#!/usr/bin/env python

import sys

def print_result(key, sum, count):
	print "average size of station for  %s\t year is: %.2f" % (last_key, sum/count)

	
(last_key, sum, count) = (None, 0.0, 0)
for line in sys.stdin:
  (key, val) = line.split("\t")
  if last_key and last_key != key:
	print_result(key, sum, count)
	(last_key, sum, count) = (key, float(val), 1)
  else:
    (last_key, sum, count) = (key, sum + float(val), count + 1)

if last_key:
  print_result(key, sum, count)
