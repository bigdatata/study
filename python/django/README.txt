https://www.djangoproject.com/
install
    pip install Django==1.8.4
    or download from https://pypi.python.org/pypi/Django/1.8.4
    then python setup.py install

1.tutorial01
    python -c "import django; print(django.get_version())"
    django-admin startproject mysite
    python manage.py migrate //to create table
    python manage.py runserver
2.Creating models
    python manage.py startapp polls
    change the INSTALLED_APPS setting to include the string 'polls'
    python manage.py makemigrations polls
    python manage.py sqlmigrate polls 0001


3.Advanced tutorial: How to write reusable apps
      install  setuptools      https://pypi.python.org/pypi/setuptools
      https://docs.djangoproject.com/en/1.8/intro/reusable-apps/