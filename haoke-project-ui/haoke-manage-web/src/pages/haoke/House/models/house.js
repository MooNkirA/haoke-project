import { message } from 'antd';
import { addHouseResource } from '@/services/haoke';

export default {
  namespace: 'house',

  state: {},

  effects: {
    // 提交房源
    *submitHouseForm({ payload }, { call }) {
      yield call(addHouseResource, payload);
      message.success('提交成功');
    },
  },

  reducers: {},
};
