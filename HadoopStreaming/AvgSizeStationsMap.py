#!/usr/bin/env python

import sys

for line in sys.stdin:
	splitted_line = line.split(',')
	date = splitted_line[4].replace('\"','')
	size = splitted_line[5]
	if(date != 'install_date'):
		print "%s\t%s" % (date.split('/')[2], size)