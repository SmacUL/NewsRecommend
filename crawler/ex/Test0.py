import logging
logging.basicConfig(filename='./log.txt', filemode='a', level=logging.INFO)

def test1():
    try:
        a =  1 + 's'
        return a
    except Exception as err:
        print("test1")
        # logging.exception(err)
        logging.info(err)

        raise err

def test2():
    try:
        a = test1()
        print(a)
    except Exception as err:
        print("test2")
        print(err)

test2()