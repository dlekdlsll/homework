-- 01. �������� ���̺� ����(��Ű��) ��ȸ
desc EMP;

-- 02. �μ� ���̺� ����(��Ű�� ��ȸ)
desc DEPT;

-- 03. ��ü������ ������� ��ȸ
SELECT * FROM EMP;

-- 04. ��ü�μ��� ������� ��ȸ
SELECT * FROM DEPT;

-- 05. ��ü������ ���, �̸�, �޿�, ��, �Ի��� ������ ��ȸ
SELECT EMPNO, ENAME, SAL, COMM, HIREDATE FROM EMP;

-- 06. �÷��� ���� ���� ����ؼ� ��ȸ
-- ������� : Employee No, Name, Salary, COMMISION, Hire Date
SELECT EMPNO "Employee No", ENAME "Name", SAL "Salary", COMM COMMISION, HIREDATE "Hire Date" FROM EMP;

-- 07. ���� ��ȸ
-- ������� : �μ���ȣ, ���, �̸�, �޿�, ����
-- ���ı��� : �޿�(��������), �μ���ȣ(��������)
SELECT DEPTNO, EMPNO, ENAME, SAL, COMM 
FROM EMP
ORDER BY SAL DESC, DEPTNO DESC;

-- ���ı��� : �μ���ȣ(��������), �޿�(��������)
SELECT DEPTNO, EMPNO, ENAME, SAL, COMM 
FROM EMP
ORDER BY DEPTNO ASC, SAL DESC;

-- 08. �ߺ��� ���� ��ȸ : distinct
-- ������ ���� ���� ��ȸ
-- ���ı��� : ���� �ø�����
SELECT DISTINCT DEPTNO, JOB FROM EMP;

-- 09. ���μ��� �ش� �μ����� ���� ���� ��ȸ
-- ������� : �μ���ȣ, ����
-- ���ı��� : �μ���ȣ �ø�, ���� �ø�
SELECT DEPTNO, JOB 
FROM EMP
ORDER BY DEPTNO, JOB;

-- 10. ���� ��ȸ
-- ������� : ���, �̸�, �޿�
-- ��ȸ���� : �޿��� 3000�̻��� ����
SELECT DEPTNO, ENAME, SAL
FROM EMP
WHERE SAL >= 3000;

-- 11. �����ȣ�� 7788 ����� �̸� �� �μ���ȣ�� ���
SELECT ENAME, DEPTNO
FROM EMP
WHERE EMPNO = 7788;

-- 12. 10�� �μ����߿��� �޿��� 3000�̻��� ����
SELECT *
FROM EMP
WHERE DEPTNO = 10 and SAL >= 3000;

-- 13. ������� : �μ���ȣ, ���, �̸�, ����
-- ��ȸ���� : ������ manager �� ����
SELECT DEPTNO, EMPNO, ENAME, JOB
FROM EMP
WHERE JOB = 'MANAGER';

-- 14. ������� : �μ���ȣ, ���, �̸�, ����
-- ��ȸ���� : ������ SALESMAN�� �ƴ� ����
SELECT DEPTNO, EMPNO, ENAME, JOB
FROM EMP
WHERE JOB != 'SALESMAN';

-- 15. �޿��� 1500�̻� ~ 2850������ ������ ���ϴ� ����� �̸� �� �޿��� ��ȸ
SELECT ENAME, SAL
FROM EMP
WHERE SAL BETWEEN 1500 AND 2850;

-- 16. �޿��� 1500�̻� ~ 2850������ ������ ������ �ʴ� ����� �̸� �� �޿��� ��ȸ
SELECT ENAME, SAL
FROM EMP
WHERE SAL NOT BETWEEN 1500 AND 2850;

-- 17. ������� : �μ���ȣ, ���, �̸�, �޿�
-- ��ȸ���� : �޿��� 3000�̻��̰ų�, �μ���ȣ 10�� ����
SELECT DEPTNO, EMPNO, ENAME, SAL
FROM EMP
WHERE SAL >= 3000 OR DEPTNO = 10;

-- 18. ������� : �μ���ȣ, ���, �̸�, ����
-- ��ȸ���� : �μ���ȣ�� 10, 20 �μ��� ��ȸ
SELECT DEPTNO, EMPNO, ENAME, JOB
FROM EMP
WHERE DEPTNO IN (10, 20);

-- 19. 10�� �� 30�� �μ��� ���ϴ� ��� ����� �̸��� �μ� ��ȣ�� ��ȸ�϶�.
-- ��, �̸��� ���ĺ������� �����Ͽ� ����϶�.
-- 1) �÷��� ���� ��ȸ
SELECT ENAME, DEPTNO
FROM EMP
WHERE DEPTNO IN (10, 30)
ORDER BY ENAME;

-- 2) alias(����) ���� ��ȸ
SELECT ENAME "Name", DEPTNO
FROM EMP
WHERE DEPTNO IN (10, 30)
ORDER BY "Name";

-- 3) ��ȸ �÷��� ���� �ε�����ȣ��  ���� ��ȸ
SELECT ENAME "Name", DEPTNO
FROM EMP
WHERE DEPTNO IN (10, 30)
ORDER BY 1;

-- ## SQL �񱳿����� ���� �˻�

-- 20. ��� �̸��� A�� ���� �ϴ� ���� �˻�
SELECT *
FROM EMP
WHERE ENAME LIKE 'A%';

-- 21. ��� �̸��� A�� ���� ���� �˻�
SELECT *
FROM EMP
WHERE ENAME LIKE '%A%';

-- 22. ����̸��� 3��° ���ڰ� A�� ���� �˻�
SELECT *
FROM EMP
WHERE ENAME LIKE '__A%';

-- 23. �̸� 5������ ������ ������ ��ȸ
SELECT *
FROM EMP
WHERE LENGTH(ENAME) = 5;

-- 24. �μ��� 10��, 20�� ���� �˻�
SELECT *
FROM EMP
WHERE DEPTNO = 10 OR DEPTNO = 20;

-- 25. �μ��� 10��, 20���� �ƴ� ���� �˻�
SELECT *
FROM EMP
WHERE NOT(DEPTNO = 10 OR DEPTNO = 20);
--
SELECT *
FROM EMP
WHERE DEPTNO != 10 AND DEPTNO != 20;

-- 26. �޿��� 1500�̻� ~ 2850������ ������ ���ϴ� ����� �̸� �� �޿��� ��ȸ
SELECT ENAME, SAL
FROM EMP
WHERE SAL >= 1500 and SAL <= 2850;

-- 27. �޿��� 1500�̻� ~ 2850������ ������ ������ �ʴ� ����� �̸� �� �޿��� ��ȸ
SELECT ENAME, SAL
FROM EMP
WHERE NOT(SAL >= 1500 and SAL <= 2850);
--
SELECT ENAME, SAL
FROM EMP
WHERE SAL < 1500 OR SAL > 2850;

-- 28. ������ ���� ���� �˻�
SELECT *
FROM EMP
WHERE COMM IS NULL;

-- 29. ������ �ִ� ���� �˻�
SELECT *
FROM EMP
WHERE COMM IS NOT NULL;

-- 30. ���� Ư���� = �޿� + ���� * 20%
-- ������ �ִ� ������ �޿� + ���� * 0.2 Ư�� ��
-- ������ ���� ������ �޿� * 0.2 Ư�� ��
-- �̸� , �޿�, ����, Ư���� ���� ���

-- 1) ������ �ִ� ���� ���� : 0�� �̻��� ���
SELECT ENAME, SAL, COMM, DEPTNO
FROM EMP
WHERE COMM >= 0;

-- 2) ������ ���� ���� ����
SELECT ENAME, SAL, COMM, DEPTNO
FROM EMP
WHERE COMM IS NULL;

-- 3) ��� ������� Ư���� ����
SELECT ENAME, SAL, COMM, DEPTNO,
CASE 
    WHEN COMM IS NULL THEN SAL*0.2
    ELSE (SAL+COMM)*0.2
    END SPCOMM
FROM EMP;

-- 31. ����� 000�� ������ �̸��� 000�̴�
SELECT EMPNO, ENAME
FROM EMP;

-- 32. �ٹ��Ⱓ�� ���� ����鿡 ���� ������ �����ϱ�� �Ͽ���.
-- �������� ���, �̸�, �Ի���, �ٹ��Ⱓ(���, �����Ϲ���)�� ������
-- �ٹ��Ⱓ�� ���� �������� ��ȸ�Ͽ���.
SELECT EMPNO, ENAME, HIREDATE, TRUNC((SYSDATE - HIREDATE)/365) WP
FROM EMP
ORDER BY WP;

-- �ٹ��Ⱓ = ���糯¥ - �Ի糯¥
-- �ٹ������ 33�� �̻��� ������ ����� ���
SELECT * 
FROM(SELECT EMPNO, ENAME, HIREDATE, TRUNC((SYSDATE - HIREDATE)/365) WP FROM EMP)
WHERE WP >= 33
ORDER BY WP;