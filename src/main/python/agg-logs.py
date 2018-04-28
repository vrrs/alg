#!/usr/bin/env python2.7
# This script aggregate http status codes per min from access logs and generate csv
# Examples:
#    ./agg-logs.py --help
#    ./agg-logs.py --dir myDir --file myOut.csv
#    ./agg-logs.py

import os
import argparse

def to_file(csv, name):
    file = open(name, 'w+')
    csv.keys().sort()
    for status_code in csv:
        file.write("#" + str(status_code) + "\n")
        csv[status_code].keys().sort()
        for date_until_min in csv[status_code]:
            file.write(date_until_min + "," 
                       + str(csv[status_code][date_until_min]) + "\n") 
    file.close()

def get_date_and_status_code(logline):
    date_until_min = None
    status_code = None
    for token in logline.split(" "):
        if token[0] == "[":
            date_until_min = token[1:-3]
        if token.isdigit():
            status_code = token
        if not date_until_min is None and not status_code is None:
            break
    return date_until_min, status_code

def list_files(dir):
    filenames = [os.path.join(dir, filename) for filename in os.listdir(dir) 
                 if filename != "agg-logs.py"]
    return [filename for filename in filenames if os.path.isfile(filename)]

def main(dir, name):
    csv = dict()
    for filename in list_files(dir):
        print "Processing " + filename
        with open(filename, 'r') as logfile:
            for logline in logfile:
                date_until_min, status_code = get_date_and_status_code(logline)
                if not status_code in csv:
                    csv[status_code] = dict()
                if date_until_min in csv[status_code]:
                    cur_count = csv[status_code][date_until_min] 
                    csv[status_code][date_until_min] = cur_count + 1
                else :
                    csv[status_code][date_until_min] = 1
        print "Finished processing " + filename
    to_file(csv, name)

def get_args():
    parser = argparse.ArgumentParser() 
    parser.add_argument("--dir", help = "Directory path containing the access logs to parse. Default is current dir", default = ".")
    parser.add_argument("--file", help = "Filename of csv. Default is out.csv", default = "out.csv")
    return parser.parse_args()

if __name__ == "__main__":
    args = get_args()
    if args.dir == ".":
        args.dir = os.path.dirname(os.path.abspath(__file__))
    main(args.dir, args.file)
    