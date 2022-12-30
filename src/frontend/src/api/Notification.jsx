import { notification } from "antd";

const openNotificationWithIcon = (type, message, description, placement="bottomRight") => {
    notification[type]({ message, description, placement});
  };

export const successNotification = (message, description) =>
    openNotificationWithIcon("success", message, description);

export const errorNotification = (message, description, placement) =>
    openNotificationWithIcon("error", message, description, placement); 
    
export const infoNotification = (message, description) =>
    openNotificationWithIcon("info", message, description); 
    
export const warningNotification = (message, description) =>
    openNotificationWithIcon("warning", message, description);