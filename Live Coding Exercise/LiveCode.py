#####################################################
# Programmer: Megan Spiers                          #
#                                                   #
# Purpose:    This was created to solve the live    #
#             coding exercise presented by RTS Labs #
#                                                   #
# Task: Refer to Cache.java file                    #
#####################################################

import time

class Cache:

    def __init__(self, maxSize):
        self.cache = {}
        self.timeUsed = {}
        self.__maxSize = maxSize

    def put(self, key, value):
        if len(self.cache) == getMaxSize():
            keyToDelete = min(timeUsed.values())
            for item in timeUsed:
                if item == keyToDelete:
                    del timeUsed[key]
                    del cache[key]
        
        elif key in cache:
            del timeUsed[key]
            del cache[key]
        
        else:
            timeUsed[key].append(time.time)
            cache[key].append(value)


    def get(self, key):
        if not self.cache:
            return null
        else:
            timeUsed[key].append(time.time)
            return self.cache[key]

    def getCurrentCacheSize(self):
        cacheLength = len(self.cache)
        return cacheLength

    def getMaxSize(self):
        return self.__maxSize

    def setMaxSize(self, maxSize):
        self.__maxSize = maxSize
