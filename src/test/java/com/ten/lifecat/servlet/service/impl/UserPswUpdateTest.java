//package com.wang.service.impl;
//
//import com.wang.bean.dto.UserVO;
//import com.wang.service.util.Service;
//import org.easymock.EasyMock;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.easymock.PowerMock;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import static org.junit.Assert.assertNotNull;
//
///**
// * UserPswUpdateServiceImpl Tester.
// *
// * @author <Authors name>
// * @version 1.0
// * @since <pre>六月 16, 2018</pre>
// */
//@RunWith(PowerMockRunner.class)
//public class UserPswUpdateTest {
//
//    private HttpServletRequest request;
//    private HttpServletResponse response;
//    private HttpSession session;
//
//    @Before
//    public void before() throws Exception {
//        // 创建request和response的Mock
//        request = EasyMock.createMock(HttpServletRequest.class);
//        response = EasyMock.createMock(HttpServletResponse.class);
//        session = EasyMock.createMock(HttpSession.class);
//    }
//
//    @After
//    public void after() throws Exception {
//    }
//
//    /**
//     * Method: newService()
//     */
//    @Test
//    public void testNewService() throws Exception {
////TODO: Test goes here...
//    }
//
//    /**
//     * Method: execute(HttpServletRequest req, HttpServletResponse resp)
//     */
//    @Test
//    @PrepareForTest({UserVO.Builder.class})
//    public void testExecute() throws Exception {
//        Service service = UserPswUpdateServiceImpl.newService();
//
//        final String path = "directoryPath";
//
//        UserVO.Builder fileMock = PowerMock.createMock(UserVO.Builder.class);
//
//
//        UserVO tested = fileMock.build();
//
//        PowerMock.expectNew(UserVO.Builder.class, 8, "a").andReturn(fileMock);
//
//        EasyMock.expect(tested.getUserId()).andReturn(8);
//
//        PowerMock.replay(fileMock, UserVO.Builder.class);
//
//
////        UserVO userDTO = PowerMock.createMockAndExpectNew(UserVO.Builder.class, 8, "test").build();
//
//        EasyMock.expect(request.getParameter("newPassword1")).andReturn("updatePassword").times(1);  //期望调用的次数
//        EasyMock.expect(request.getSession()).andReturn(session);
//        EasyMock.expect(session.getAttribute("user")).andReturn(tested);
//
//        PowerMock.replay(request, tested);   //保存期望结果
//
//        ServiceResult result = service.execute(request, response);
//
//        System.out.println("page " + result.getPage());
//        System.out.println("msg" + result.getErrormsg());
//
//        assertNotNull(result.getPage());
//        assertNotNull(result.getErrormsg());
//    }
//
//}
