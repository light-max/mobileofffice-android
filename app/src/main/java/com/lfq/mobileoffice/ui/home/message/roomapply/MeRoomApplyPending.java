package com.lfq.mobileoffice.ui.home.message.roomapply;

import com.lfq.mobileoffice.data.result.RoomApplyPager;
import com.lfq.mobileoffice.net.Api;
import com.lfq.mobileoffice.net.Net;
import com.lfq.mobileoffice.ui.home.message.MessageRecyclerFragment;

/**
 * 消息中: 待审核的预约申请
 */
public class MeRoomApplyPending extends MessageRecyclerFragment<AdapterMeRoomApply> {
    @Override
    public void onRefresh() {
        Api.roomApplyPending().success((Net.OnSuccess<RoomApplyPager>) roomApplyPager -> {
            setData(roomApplyPager.getData());
        }).run();
    }
}
